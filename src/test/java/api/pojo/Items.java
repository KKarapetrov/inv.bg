package api.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Items {
    private String name;
    private int price_for_quantity;
    private String quantity_unit;
}
