package com.hanocybous.ecommercesystem.config.corsconfig.corsconfigimpl;

import com.hanocybous.ecommercesystem.config.corsconfig.ICorsConfig;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class CorsConfigFactory {

    @Contract(" -> new")
    public static @NotNull ICorsConfig getCorsConfig() {
        return new CorsConfig();
    }

}
