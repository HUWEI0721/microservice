package com.storecloud.api.client.fallback;

import com.storecloud.api.client.ItemClient;
import com.storecloud.api.dto.ItemDTO;
import com.storecloud.api.dto.OrderDetailDTO;
import com.storecloud.common.utils.CollUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.Collection;
import java.util.List;

@Slf4j
public class ItemClientFallbackFactory implements FallbackFactory<ItemClient> {
    @Override
    public ItemClient create(Throwable cause) {
        return new ItemClient() {
            @Override
            public List<ItemDTO> queryItemByIds(Collection<Long> ids) {
                log.error("查询商品失败", cause);
                return CollUtils.emptyList();
            }

            @Override
            public void deductStock(List<OrderDetailDTO> items) {
                log.error("扣减商品库存失败", cause);
                throw new RuntimeException(cause);
            }
        };
    }
}
