package ch.heigvd.gen2019;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {

        this.orders = orders;
    }

    public String getContents() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");

        for (int i = 0; i < orders.getOrdersCount(); i++) {
            Order order = orders.getOrder(i);
            sb.append("{");
            sb.append("\"id\": ");
            sb.append(order.getOrderId());
            sb.append(", ");
            sb.append("\"products\": [");
            for (int j = 0; j < order.getProductsCount(); j++) {

                sb.append("{");
                sb.append("\"code\": \"");
                sb.append(order.getProduct(j).getCode());
                sb.append("\", ");
                sb.append("\"color\": \"");
                sb.append(order.getProduct(j).getColor());
                sb.append("\", ");

                if (order.getProduct(j).getSize() != Size.SIZE_NOT_APPLICABLE) {
                    sb.append("\"size\": \"");
                    sb.append(order.getProduct(j).getSize());
                    sb.append("\", ");
                }

                sb.append("\"price\": ");
                sb.append(order.getProduct(j).getPrice());
                sb.append(", ");
                sb.append("\"currency\": \"");
                sb.append(order.getProduct(j).getCurrency());
                sb.append("\"}, ");
            }

            if (order.getProductsCount() > 0) {
                sb.delete(sb.length() - 2, sb.length());
            }

            sb.append("]");
            sb.append("}, ");
        }

        if (orders.getOrdersCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}").toString();
    }

}