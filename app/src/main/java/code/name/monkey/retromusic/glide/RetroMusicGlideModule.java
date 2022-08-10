package code.name.monkey.retromusic.glide;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

import java.io.InputStream;

import code.name.monkey.retromusic.glide.artistimage.ArtistImage;
import code.name.monkey.retromusic.glide.artistimage.Factory;
import code.name.monkey.retromusic.glide.audiocover.AudioFileCover;
import code.name.monkey.retromusic.glide.audiocover.AudioFileCoverLoader;
import code.name.monkey.retromusic.glide.palette.BitmapPaletteTranscoder;
import code.name.monkey.retromusic.glide.palette.BitmapPaletteWrapper;
import code.name.monkey.retromusic.glide.playlistPreview.PlaylistPreview;
import code.name.monkey.retromusic.glide.playlistPreview.PlaylistPreviewLoader;

@GlideModule
public class RetroMusicGlideModule extends AppGlideModule {

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        registry.prepend(PlaylistPreview.class, Bitmap.class, new PlaylistPreviewLoader.Factory(context));
        registry.prepend(AudioFileCover.class, InputStream.class, new AudioFileCoverLoader.Factory());
        registry.prepend(ArtistImage.class, InputStream.class, new Factory(context));
        registry.register(Bitmap.class, BitmapPaletteWrapper.class, new BitmapPaletteTranscoder());
    }

    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}
