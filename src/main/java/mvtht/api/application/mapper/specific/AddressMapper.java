package mvtht.api.application.mapper;

import lombok.RequiredArgsConstructor;
import mvtht.api.application.dtos.request.AddressRequest;
import mvtht.api.domain.models.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressMapper {

    @Autowired
    private ModelMapper mapper;

    public Address toAddress(AddressRequest request) { return mapper.map(request, Address.class); }

}
