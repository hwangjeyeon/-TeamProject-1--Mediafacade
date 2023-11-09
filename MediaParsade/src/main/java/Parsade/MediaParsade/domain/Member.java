package Parsade.MediaParsade.domain;


import lombok.Data;

@Data
public class Member {

    private Long id;
    private String name;
    private String studentId;
    private String type;
    private String text;
    private String selection;
    private Property property;

}
