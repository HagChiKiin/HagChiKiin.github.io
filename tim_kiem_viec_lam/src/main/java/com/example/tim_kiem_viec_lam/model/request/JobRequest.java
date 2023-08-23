package com.example.tim_kiem_viec_lam.model.request;

import com.example.tim_kiem_viec_lam.entity.Recruiter;
import com.example.tim_kiem_viec_lam.statics.JobStatus;
import com.example.tim_kiem_viec_lam.statics.Literacy;
import com.example.tim_kiem_viec_lam.statics.WorkType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobRequest {

    Long id;

    LocalDateTime createdDateTime;

    String createdBy;

    LocalDateTime lastModifiedDateTime;

    String lastModifiedBy;

    Recruiter recruiter;

    @NotBlank(message = "Địa chỉ không được để trống")
    @Size(max = 255, message = "Địa chỉ không được quá 255 ký tự")
    String location;

    @NotBlank(message = "Tiêu đề không được để trống")
    @Size(max = 50, message = "Tiêu đề không được quá 50 ký tự")
    String title;

    @NotBlank(message = "Chi tiết công việc không được để trống")
    String detail;

    @Min(value = 0, message = "Kinh nghiệm phải là số không âm")
    int yoe;

    @NotNull(message = "Trình độ học vấn không được để trống")
    Literacy literacy;

    @NotNull(message = "Loại công việc không được để trống")
    WorkType workType;

    @NotBlank(message = "Quyền lợi không được để trống")
    String benefit;

    @Min(value = 0, message = "Lương tối thiểu phải là số không âm")
    Integer salaryFrom;

    @Min(value = 0, message = "Lương tối đa phải là số không âm")
    Integer salaryTo;

    @NotNull(message = "Trạng thái công việc không được để trống")
    JobStatus jobStatus;

    @NotBlank(message = "Yêu cầu công việc không được để trống")
    String requirement;

    LocalDateTime publishDateTime;

    LocalDate dueDateTime;

    LocalDateTime closeDateTime;

    List<String> skill;

    LocalDateTime deletedDateTime;

}
