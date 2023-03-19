package org.jfatech.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Fellipe Toledo
 */
@Data
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private boolean success;
}
