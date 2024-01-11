package com.ankur.user.model;

import com.ankur.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateBO {

    private User user;
    private Department department;
}
