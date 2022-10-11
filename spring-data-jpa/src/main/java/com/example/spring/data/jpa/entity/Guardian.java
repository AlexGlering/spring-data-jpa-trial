package com.example.spring.data.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

//Not going to be annotated as an Entity as there is no need to write it to a table.
//Parameters only used as an FK in the Student entity.
@Embeddable //can be embedded in the student entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//Overriding pre-existing columns with the post-defined attributes.
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_mobile")
        )
})

public class Guardian {

    private String name;
    private String email;
    private String mobile;
}

