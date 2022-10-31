package dev.practice.order.domain.partner;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Getter
public class PartnerInfo {
    private final Long id;
    private final String partnerToken;
    private final String partnerName;
    private final String businessNo;
    private final String email;
    private final Partner.Status status;

    @Builder
    public PartnerInfo(Long id, String partnerToken, String partnerName, String businessNo, String email,
        Partner.Status status) {
        this.id = id;
        this.partnerToken = partnerToken;
        this.partnerName = partnerName;
        this.businessNo = businessNo;
        this.email = email;
        this.status = status;
    }

    public PartnerInfo(Partner partner) {
        this.id = partner.getId();
        this.partnerToken = partner.getPartnerToken();
        this.partnerName = partner.getPartnerName();
        this.businessNo = partner.getBusinessNo();
        this.email = partner.getEmail();
        this.status = partner.getStatus();
    }
}
