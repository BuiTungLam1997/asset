package com.example.asset.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.stereotype.Component;

@Component
public class CustomSitemeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder
                .addDecoratorPath("/admin/*", "/decorators/admin.jsp")
                .addDecoratorPath("/user*", "/decorators/user.jsp")
                .addDecoratorPath("/comment*", "/decorators/comment.jsp")
                .addDecoratorPath("/login*", "/decorators/login.jsp")
                .addDecoratorPath("/*", "/decorators/web.jsp")
                .addExcludedPath("/api*");
    }
}
