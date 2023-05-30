package com.hotels.mart.application.services.sales;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hotels.mart.application.dto.ResponseFormat;
import com.hotels.mart.application.services.emails.EmailService;
import com.hotels.mart.application.services.paymentsMethod.GetPaymentMethodByIdService;
import com.hotels.mart.application.services.reservation.GetReservationById;
import com.hotels.mart.application.services.sales.salesState.GetSaleStateByIdService;
import com.hotels.mart.application.services.user.GetUserByIdService;
import com.hotels.mart.domain.entities.Sale;
import com.hotels.mart.infrastructure.jpa.repositories.SalesRepository;

@Service
public class CreateSaleService {
  @Autowired
  private EmailService emailService;
  @Autowired
  private SalesRepository salesRepository;

  // Services
  @Autowired
  private GetUserByIdService getUserByIdService;

  @Autowired
  private GetReservationById getReservationById;

  @Autowired
  private GetSaleStateByIdService getSaleState;

  @Autowired
  private GetPaymentMethodByIdService GetPaymentMethodByIdService;

  public ResponseFormat createSale(Sale sale) {

    // Verificar que tenga la estructura correcta
    if (sale.getUser() == null || sale.getReservation() == null ||
        sale.getSales_state() == null || sale.getPayment_method() == null) {
      String expectedStructure = "{"
          + "\"user\": {\"user_id\": 0},                                 "
          + "\"reservation\": \n {\"reservation_id\": 0},                "
          + "\"sales_state\": {\"sales_state_id\": 0},                   "
          + "\"payment_method\": {\"payment_method_id\": 0}              "
          + "}";
      ResponseFormat responseFormat = new ResponseFormat(
          "La estructura de la entrada es incorrecta, Debe ser     :" + expectedStructure,
          HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());

      return responseFormat;
    }

    // Verificar si user exist
    var user = getUserByIdService.getUserById(sale.getUser().getUser_id());

    if (user.isEmpty()) {
      ResponseFormat responseFormat = new ResponseFormat("El id del User no existe",
          HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());

      return responseFormat;
    }

    // Verificar si reservation id Existe
    var reservation = getReservationById.getReservationById(sale.getReservation().getReservation_id());

    if (reservation.isEmpty()) {
      ResponseFormat responseFormat = new ResponseFormat("El id de la Reserva no existe",
          HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());

      return responseFormat;
    }

    // Verificar si es estado del Pago existe
    var paymentMethod = GetPaymentMethodByIdService
        .getPaymentMethodByID(sale.getPayment_method().getPayment_method_id());
    if (paymentMethod.isEmpty()) {
      ResponseFormat responseFormat = new ResponseFormat("El metodo de pago no existe",
          HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
      return responseFormat;
    }

    // Verifical que es estado de la compra se valido
    var saleState = getSaleState.getSaleStateById(sale.getSales_state().getSales_state_id());
    if (saleState.isEmpty()) {
      ResponseFormat responseFormat = new ResponseFormat("El Estado pago no existe",
          HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
      return responseFormat;
    }

    // Si todo es valido WELL DONE
    salesRepository.save(sale);
    var response = emailService.sendEmail("andresolano34@gmail.com",
    "daolano58@ucatolica.edu.co", "equipo de ventas", "Hizo una compra");
    ResponseFormat responseFormat = new ResponseFormat("Venta exitosa ...:D",
        HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
    return responseFormat;
  }
}
