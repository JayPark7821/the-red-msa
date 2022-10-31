package dev.practice.order.domain.notification;

public interface NotificationService {
    void sendEmail(String email, String title, String description);

    void sendKaKao(String phoneNo, String description);

    void sendSms(String phoneNo, String description);
}
