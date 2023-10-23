package br.com.contas.demo.service;

import br.com.contas.demo.dto.ClientDTO;
import br.com.contas.demo.dto.DeliveryDTO;
import br.com.contas.demo.entity.*;
import br.com.contas.demo.repository.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DeliveryServiceTest {

    private DeliveryService underTest;

    @Mock
    private DeliveryRepository repository;

    @Mock
    private  OrdersRepository ordersRepository;
    @Mock
    private Client_Repository clientRepository;
    @Mock
    private ItemRepository itemRepository;
    ClientDTO client;

    @BeforeEach
    public void Setup() {

       MockitoAnnotations.initMocks(this);
       underTest = new DeliveryService(repository);


    }

    @Test
    void findall() {
        //when
        underTest.Findall();
        //then
        verify(repository).findAll();
    }





//    @Test
//    @Disabled
//
//    void findByMetodoEntrega() {
//
//        //given
//        List<Delivery> deliveries = new ArrayList<>();
//        Delivery entrega = new Delivery();
//        entrega.setMetodoEntrega(MetodoEntrega.DELIVERY);
//        entrega.setDeliveryName("james");
//        Optional<Orders> ordem = ordersRepository.findById(1L);
//        entrega.setOrder(ordem.get());
//        deliveries.add(entrega);
//        Mockito.when(repository.findByMetodoEntrega(MetodoEntrega.DELIVERY)).thenReturn(deliveries);
//        //when
//       List<Delivery> expected =  underTest.FindByMetodoEntrega(MetodoEntrega.DELIVERY);
//       //then
//        verify(repository).findByMetodoEntrega(MetodoEntrega.DELIVERY);
//        Assertions.assertThat(expected).isNotEmpty();
//
//    }

    @Test

    void create() {
        //given
        Delivery entrega = new Delivery();
        entrega.setMetodoEntrega(MetodoEntrega.DELIVERY);
        entrega.setDeliveryName("james");
        DeliveryDTO deliveryDTO = new DeliveryDTO();
        BeanUtils.copyProperties(entrega, deliveryDTO);
        //when
        underTest.create(deliveryDTO);
        ArgumentCaptor<Delivery> deliveryArgumentCaptor = ArgumentCaptor.forClass(Delivery.class);


        //then
        verify(repository).save(deliveryArgumentCaptor.capture());

    }

//    @Test
//    @Disabled
//    void update() {
//        //given
//        Delivery entrega = new Delivery();
//        entrega.setMetodoEntrega(MetodoEntrega.DELIVERY);
//        entrega.setDeliveryName("james");
//        DeliveryDTO deliveryDTO = new DeliveryDTO();
//        BeanUtils.copyProperties(entrega, deliveryDTO);
//        deliveryDTO.setDeliveryName("jailson");
//        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(entrega));
//
//        //when
//        Delivery expected =  underTest.update(1L, deliveryDTO);
//        ArgumentCaptor<Delivery> deliveryArgumentCaptor = ArgumentCaptor.forClass(Delivery.class);
//
//        //then
//        verify(repository).save(deliveryArgumentCaptor.capture());
//        Assertions.assertThat(expected.getDeliveryName()).isEqualTo(deliveryDTO.getDeliveryName());
//    }



    @Test


    void delete() {
        //given
        Delivery entrega = new Delivery();
        entrega.setMetodoEntrega(MetodoEntrega.DELIVERY);
        entrega.setDeliveryName("james");
        DeliveryDTO deliveryDTO = new DeliveryDTO();
        BeanUtils.copyProperties(entrega, deliveryDTO);
        deliveryDTO.setDeliveryName("jailson");
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(entrega));

        //when

        ResponseEntity<String> expected = underTest.delete(1L);
        ArgumentCaptor<Delivery> deliveryArgumentCaptor = ArgumentCaptor.forClass(Delivery.class);

        //then
        verify(repository).delete(deliveryArgumentCaptor.capture());
        Assertions.assertThat(expected.getStatusCode()).isEqualTo(HttpStatus.OK);


    }
}
