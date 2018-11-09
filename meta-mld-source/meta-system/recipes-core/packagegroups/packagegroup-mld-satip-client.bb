DESCRIPTION = "MLD satip-client Package"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup 

RDEPENDS_${PN} = " \
    vdr \
    vdr-plugin-satip \
"
