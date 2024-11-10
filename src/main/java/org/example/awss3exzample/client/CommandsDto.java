package org.example.awss3exzample.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommandsDto implements Serializable {
    private Integer scaleId;
    private Boolean openGate1;
    private Boolean closeGate1;
    private Boolean weighing;
    private Boolean openGate2;
    private Boolean closeGate2;


    @Override
    public String toString() {
        return "CommandsDto(scaleId=" + scaleId + ", openGate1=" + openGate1 + ", closeGate1=" + closeGate1 +
                ", weighing=" + weighing + ", openGate2=" + openGate2 + ", closeGate2=" + closeGate2 + ")";
    }
}
