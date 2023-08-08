import com.br.weather.controller.WeatherController;
import com.br.weather.model.WeatherModelo;
import com.br.weather.view.WeatherView;


public class Main {
    public static void main(String[] args)  {
        WeatherView view = new WeatherView();
        WeatherModelo model = new WeatherModelo();
        WeatherController controller = new WeatherController(model, view);

        controller.updateView();
    }
}