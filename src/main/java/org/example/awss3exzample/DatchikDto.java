package org.example.awss3exzample;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DatchikDto {
    private Integer scaleId;
    private Boolean controller=false;
    private Boolean gate1=false;
    private Boolean gate2=false;
    private Boolean camera1=false;
    private Boolean camera2=false;
    private Boolean camera3=false;
    private Boolean sensor1=false;
    private Boolean sensor2=false;
    private Boolean sensor3=false;
}
