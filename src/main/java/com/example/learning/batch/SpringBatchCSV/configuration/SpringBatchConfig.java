package com.example.learning.batch.SpringBatchCSV.configuration;

import com.example.learning.batch.SpringBatchCSV.pojo.Users;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, ItemReader<Users> itemReader,
                   ItemProcessor<Users,Users> itemProcessor,
                   ItemWriter<Users> itemWriter) {

        Step step=stepBuilderFactory.get("ETL-File-Load")
                .<Users,Users>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

        return jobBuilderFactory.get("ETL-Test")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }


}
