package umc.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MissionHomeDTO {
    private String storeName;
    private String missionSpec;
    private Integer reward;
    private String address;
}
