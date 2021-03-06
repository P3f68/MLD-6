DESCRIPTION = "MLD base Package"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup 

RDEPENDS__${PN} = " \
    busybox \
    udev \
    initscripts \
    sysvinit \
    acl \
    attr \
    nfs-utils \
    xfsprogs \
    btrfs-tools \
    dialog \
    findutils \
    gptfdisk \
    gettext \
    gettext-runtime \
    ssh \
    hdparm \
    modutils-initscripts \
    base \
    psplash \
"
