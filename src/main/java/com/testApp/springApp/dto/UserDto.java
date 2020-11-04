package com.testApp.springApp.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Getter
@Setter
@Validated
public class UserDto {

    private Long id;

    @NotBlank(message = "Employee should not be blank.")
    private Long employeeId;

    @NotBlank
    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

//    @Override
//    public String toString() {
//        return "UserDto{" +
//                "id=" + id +
//                ", employeeId=" + employeeId +
//                ", name='" + name + '\'' +
//                ", createdAt=" + createdAt +
//                ", updatedAt=" + updatedAt +
//                ", deletedAt=" + deletedAt +
//                '}';
//    }
}
