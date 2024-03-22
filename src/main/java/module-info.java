module Celestial.Siege {
    requires hanyaeger;

    exports CelestialSiege;

    opens audio;
    opens backgrounds;
    //opens sprites;
exports CelestialSiege.scenes;

    // When adding to resources, make sure to provide "open foldername" in this module descriptor
}