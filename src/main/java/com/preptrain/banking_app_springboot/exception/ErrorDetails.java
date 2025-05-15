package com.preptrain.banking_app_springboot.exception;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime timeStamp,
                           String message,
                           String details,
                           String errorCode) {

}
