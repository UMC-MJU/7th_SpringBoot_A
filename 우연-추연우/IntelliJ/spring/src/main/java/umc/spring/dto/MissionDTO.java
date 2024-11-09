package umc.spring.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MissionDTO {
    private Long missionId;
    private String storeName;
    private Integer reward;
    private String missionSpec;
    private String status;

    @QueryProjection
    public MissionDTO(Long missionId, String storeName, Integer reward, String missionSpec, String status) {
        this.missionId = missionId;
        this.storeName = storeName;
        this.reward = reward;
        this.missionSpec = missionSpec;
        this.status = status;
    }

    @Override
    public String toString() {
        return "MissionDTO{" +
                "missionId=" + missionId +
                ", storeName='" + storeName + '\'' +
                ", reward=" + reward +
                ", missionSpec='" + missionSpec + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
