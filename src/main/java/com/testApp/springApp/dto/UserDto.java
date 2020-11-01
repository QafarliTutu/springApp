package com.testApp.springApp.dto;

import com.testApp.springApp.model.Employee;
import com.testApp.springApp.model.UsersRoles;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;


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
