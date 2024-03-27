module Celestial.Siege {
    requires hanyaeger;

    exports CelestialSiege;

    opens audio;
    opens backgrounds;
    opens sprites;
    opens sprites.aliens;

    exports CelestialSiege.scenes;
    exports CelestialSiege.entities.map;

    // When adding to resources, make sure to provide "open foldername" in this module descriptor
}