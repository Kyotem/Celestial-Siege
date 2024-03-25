module Celestial.Siege {
    requires hanyaeger;


    exports CelestialSiege;

    opens audio;
    opens backgrounds;
    opens sprites;

    exports CelestialSiege.scenes;
    exports CelestialSiege.entities.map;
}