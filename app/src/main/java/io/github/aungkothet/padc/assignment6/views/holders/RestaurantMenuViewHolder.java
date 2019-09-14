package io.github.aungkothet.padc.assignment6.views.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.aungkothet.padc.assignment6.R;
import io.github.aungkothet.padc.assignment6.data.vos.MenuVo;
import io.github.aungkothet.padc.assignment6.delegates.RestaurantItemDelegate;

public class RestaurantMenuViewHolder extends BaseViewHolder<MenuVo> {

    @BindView(R.id.tv_menu_name)
    TextView menuName;

    @BindView(R.id.tv_menu_price)
    TextView menuPrice;

    public RestaurantMenuViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindData(MenuVo data) {
        menuName.setText(data.getName());
        menuPrice.setText(data.getPrice());
    }
}
