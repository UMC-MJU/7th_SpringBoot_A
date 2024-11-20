package umc.spring.service.Store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository.RegionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.store.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final RegionRepository regionRepository;

    private final StoreRepository storeRepository;


    public Store addStore(StoreRequestDTO.addDTO request) {

        String regionName = request.getAddress().split(" ")[0];

        if (regionName.endsWith("시")) {
            regionName = regionName.substring(0, regionName.length() - 1);
        }

        Region region = regionRepository.findRegionByName(regionName);

        Store newStore = StoreConverter.toStore(request, region);

        return storeRepository.save(newStore);
    }
}
