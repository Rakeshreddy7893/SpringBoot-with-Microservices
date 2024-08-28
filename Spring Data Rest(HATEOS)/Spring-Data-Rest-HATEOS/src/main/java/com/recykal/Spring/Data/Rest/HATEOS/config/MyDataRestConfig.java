package com.recykal.Spring.Data.Rest.HATEOS.config;

import com.recykal.Spring.Data.Rest.HATEOS.entity.Book;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration configuration ,CorsRegistry cors){

        HttpMethod[] unsupportedMethods={HttpMethod.PUT,HttpMethod.DELETE,HttpMethod.PATCH};
        configuration.getExposureConfiguration()
                .forDomainType(Book.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedMethods)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedMethods)));

    }


}
