SUMMARY = "MLD patch for dpkg package"
HOMEPAGE = "http://www.minidvblinux.de"

EXTRA_OECONF = "\
        --disable-dselect \
        --with-zlib \
        --with-bz2 \
        --without-liblzma \
        --without-selinux \
        "


