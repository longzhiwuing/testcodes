package com.lzwing.testcode.gist.beancopy.mapstruct;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/11/7
 * Time: 11:17
 */
public class Tester {
    public static void main(String[] args) {
        shouldMapCarToDto();
    }

    public static void shouldMapCarToDto() {
        //given
        Car car = new Car("Morris",5,CarType.SEDAN);

        //when
        CarDto carDto = CarMapper.INSTANCE.carToCarDto( car );

        //then
        assertThat(carDto).isNotNull();
        assertThat(carDto.getMake()).isEqualTo( "Morris" );
        assertThat(carDto.getSeatCount()).isEqualTo( 5 );
        assertThat(carDto.getType()).isEqualTo( "SEDAN" );
    }
}
