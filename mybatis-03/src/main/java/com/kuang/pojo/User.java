package com.kuang.pojo;

import lombok.*;
import org.apache.ibatis.type.Alias;

//实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private int id;
    private String name;
    private String pwd;

}