package trello.alextrello.record.dto;

import org.springframework.stereotype.Component;
import trello.alextrello.entity.CartRecord;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CartRecordCustomMapper {

    public static List<CartRecordDto> mapToCartRecordListDto(Set<CartRecord> cartRecords){
        return cartRecords.stream()
                .map(CartRecordCustomMapper::mapToCartRecordDto)
                .collect(Collectors.toList());
    }

    public static CartRecordDto mapToCartRecordDto(CartRecord cartRecord){
        return CartRecordDto.builder()

                .title(cartRecord.getTitle())
                .description(cartRecord.getDescription())
                .comment(cartRecord.getComment())
                .deadline(cartRecord.getDeadline())
                .id(cartRecord.getId())
                .order(cartRecord.getRecordOrder())
                .build();
    }

    public static CartRecord mapToCartRecord(CartRecordDto cartRecordDto){
        CartRecord cartRecord = new CartRecord();
        cartRecord.setId(cartRecordDto.getId());
        cartRecord.setRecordOrder(cartRecordDto.getOrder());
        cartRecord.setComment(cartRecordDto.getComment());
        cartRecord.setDeadline(cartRecordDto.getDeadline());
        cartRecord.setDescription(cartRecordDto.getDescription());
        cartRecord.setTitle(cartRecordDto.getTitle());
        return cartRecord;
    }
}
