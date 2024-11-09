package umc.spring.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MissionRegionDTO {

    private Long missionId;
    private String storeName;
    private Integer reward;
    private String missionSpec;
    private Integer daysLeft;

    @QueryProjection
    public MissionRegionDTO(Long missionId, String storeName, Integer reward, String missionSpec, Integer daysLeft) {
        this.missionId = missionId;
        this.storeName = storeName;
        this.reward = reward;
        this.missionSpec = missionSpec;
        this.daysLeft = daysLeft;
    }

    @Override
    public String toString() {
        return "MissionDto{" +
                "missionId=" + missionId +
                ", storeName='" + storeName + '\'' +
                ", reward=" + reward +
                ", missionSpec='" + missionSpec + '\'' +
                ", daysLeft=" + daysLeft +
                '}';
    }
}
