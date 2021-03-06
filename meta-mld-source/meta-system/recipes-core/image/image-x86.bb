##############################################################
#
#  conten: mld-base-image
#  arch:   x86  
#   
##############################################################

SUMMARY = "A MLD base image ."

DESCRIPTION = "An image containing the BASE system for MLD ${DISTRO_VERSION} "

HOMEPAGE = "http://www.minidvblinux.de"

LICENSE = "MIT"

include recipes-core/images/core-image-minimal.bb

INITRAMFS_MAXSIZE ??= "262144"

PACKAGE_INSTALL_append = " \
    kernel-modules\
    base \
    findutils \
    init-mld \
    initramfs \
    install \
    locales \
    network \
    ssh-mld \
    udev-mld \
    urldecode \
    webserver \
    gettext \
    gettext-runtime \
    init-ifupdown \
    network \
    apt \
    "

PACKAGE_ARCH = "${MACHINE_ARCH}"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
              
GLIBC_GENERATE_LOCALES = "de_DE.UTF-8"
IMAGE_LINGUAS ?= "de-de"

#LABELS = "MLD"
LABELS_LIVE ?= "MLD boot install"

#SPLASH_IMAGE = "silent.png"

IMAGE_FEATURES += "package-management ssh-server-openssh splash"

# Base this image on mld-image-minimal
# include recipes-core/images/mld-vdr-image.bb


INITRAMFS_IMAGE = "MLD-initramfs"
INITRAMFS_IMAGE_BUNDLE = "1"

INITRD_IMAGE = "MLD-initramfs"
INITRD_IMAGE = "initramfs-framework"
IMAGE_FSTYPES = "iso"

#VIRTUAL-RUNTIME_login_manager = "busybox"
#VIRTUAL-RUNTIME_init_manager = "busybox"
#VIRTUAL-RUNTIME_initscripts = "init"


#IMAGE_INSTALL = " "
#ROOTFS = " "

# Alle Einstellungen die sich auf das Syslinux beziehen
AUTO_SYSLINUXMENU = "1"
#SYSLINUX_SPLASH = "${WORKDIR}/silent.png"
#SYSLINUX_ROOT = "root=/"
#APPEND = "vga=0x314 splash=verbose nobg apm=off"

export IMAGE_BASENAME="x86"
