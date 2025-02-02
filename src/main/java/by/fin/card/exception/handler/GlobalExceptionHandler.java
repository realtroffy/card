package by.fin.card.exception.handler;

import by.fin.card.exception.CollectFilesFromDirectoryException;
import by.fin.card.exception.ErrorDetails;
import by.fin.card.exception.InvalidFileExtensionException;
import by.fin.card.exception.ReadByteException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<?> handleProductNotFoundException(
      NoSuchElementException ex, WebRequest request) {
    String currentTime = DATE_FORMAT.format(new Date());
    log.error("[{}]: {}", currentTime, ex.getMessage());
    ErrorDetails errorDetails =
        new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(InvalidFileExtensionException.class)
  public ResponseEntity<?> handleInvalidFileExtensionException(
      InvalidFileExtensionException ex, WebRequest request) {
    String currentTime = DATE_FORMAT.format(new Date());
    log.error("[{}]: {}", currentTime, ex.getMessage());
    ErrorDetails errorDetails =
        new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ReadByteException.class)
  public ResponseEntity<?> handleReadByteException(ReadByteException ex, WebRequest request) {
    String currentTime = DATE_FORMAT.format(new Date());
    log.error("[{}]: {}", currentTime, ex.getMessage());
    ErrorDetails errorDetails =
        new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(CollectFilesFromDirectoryException.class)
  public ResponseEntity<?> handleCollectFilesFromDirectoryException(
      CollectFilesFromDirectoryException ex, WebRequest request) {
    String currentTime = DATE_FORMAT.format(new Date());
    log.error("[{}]: {}", currentTime, ex.getMessage());
    ErrorDetails errorDetails =
        new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
    String currentTime = DATE_FORMAT.format(new Date());
    log.error("[{}]: {}", currentTime, ex.getMessage());
    ErrorDetails errorDetails =
        new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }
}
