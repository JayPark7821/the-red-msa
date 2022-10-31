package dev.practice.order.interfaces.partner;

import dev.practice.order.application.partner.PartnerFacade;
import dev.practice.order.common.response.CommonResponse;
import dev.practice.order.domain.partner.PartnerCommand;
import dev.practice.order.domain.partner.PartnerInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/partners")
public class PartnerApiController {
    private final PartnerFacade partnerFacade;
    private final PartnerDtoMapper partnerDtoMapper;

    @PostMapping
    public CommonResponse registerPartner(PartnerDto.RegisterRequest request) {
        // 1. 외부전달 파라미터 (dto) -> Command , convert
        // PartnerCommand command = request.toCommand();
        PartnerCommand command = partnerDtoMapper.of(request);
        // 2. facade 호출 .. PartnerInfo
        PartnerInfo partnerInfo = partnerFacade.registerPartner(command);
        // 3. PartnerInfo -> CommonResponse convert and return
        return CommonResponse.success(new PartnerDto.RegisterResponse(partnerInfo));
    }
}
