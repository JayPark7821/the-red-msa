package dev.practice.order.domain.partner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PartnerServiceImpl implements PartnerService{
// 최대한 추상화하여 코드가 읽히도록!!!
    private final PartnerStore partnerStore;
    private final PartnerReader partnerReader;

    @Override
    @Transactional
    public PartnerInfo registerPartner(PartnerCommand command) {
        // 1. command -> Partner
        Partner initPartner = command.toEntity();
        // 2. Partner -> save to DB
        Partner partner = partnerStore.store(initPartner);
        // 3. Partner -> PartnerInfo -> return
        return new PartnerInfo(partner);

    }

    @Override
    public PartnerInfo getPartnerInfo(String partnerToken) {
        // 1. partnerToken -> Partner
        Partner partner = partnerReader.getPartner(partnerToken);
        // 2. Partner -> PartnerInfo -> Return
        return new PartnerInfo(partner);
    }

    @Override
    @Transactional
    public PartnerInfo enablePartner(String partnerToken) {
        // 1. partnerToken -> Partner
        Partner partner = partnerReader.getPartner(partnerToken);
        // 2. Partner.enable()
        partner.enable();
        // 3. return
        return new PartnerInfo(partner);
    }

    @Override
    @Transactional
    public PartnerInfo disablePartner(String partnerToken) {
        // 1. partnerToken -> Partner
        Partner partner = partnerReader.getPartner(partnerToken);
        // 2. Partner.disable()
        partner.enable();
        // 3. return
        return new PartnerInfo(partner);
    }
}
