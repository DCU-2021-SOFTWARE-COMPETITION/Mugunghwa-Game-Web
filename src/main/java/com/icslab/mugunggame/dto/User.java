package com.icslab.mugunggame.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    /* index 번호 */
    int idx;

    /* 고유번호 */
    String identificationNumber;

    /* 이름 */
    String userName;

    /*기록*/
    String recordScore;


}
