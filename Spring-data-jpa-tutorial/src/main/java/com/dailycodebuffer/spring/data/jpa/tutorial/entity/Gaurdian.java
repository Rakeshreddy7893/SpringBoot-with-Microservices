package com.dailycodebuffer.spring.data.jpa.tutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name="name",
                column=@Column(name="gaurdian_name")
        ),

        @AttributeOverride(
                name="email",
                column=@Column(name="gaurdian_email")
        ),

        @AttributeOverride(
                name="mobile",
                column=@Column(name="gaurdian_mobile")
        )
})
public class Gaurdian {

    private String name;
    private String email;
    private  String mobile;
}
