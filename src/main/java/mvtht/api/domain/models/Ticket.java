package mvtht.api.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mvtht.api.domain.dtos.ticket.TicketType;

import java.math.BigDecimal;

@Entity
@Table(name = "tickets")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_type")
    private TicketType ticketType;

    @Column(name = "ticket_price")
    private BigDecimal ticketPrice;

    @ManyToOne
    @JoinColumn(name = "id_Order")
    private Order idOrder;

    @ManyToOne
    @JoinColumn(name = "id_showtime")
    private Showtime idShowtime;

}
