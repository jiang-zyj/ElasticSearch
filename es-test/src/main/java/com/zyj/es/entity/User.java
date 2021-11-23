package com.zyj.es.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: ElasticSearch
 * @ClassName User
 * @author: YaJun
 * @Date: 2021 - 11 - 23 - 20:07
 * @Package: com.zyj.es.entity
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    private String name;
    private String sex;
    private Integer age;

}
