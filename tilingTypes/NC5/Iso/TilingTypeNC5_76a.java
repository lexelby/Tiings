package tilingTypes.NC5.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_76a
   extends TilingType
{
   public TilingTypeNC5_76a(){
      super( "NC5-76: Split square", 5, SymmetryType.p4 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 61, 18};
      paramName = new String[]{ "Indent X", "Indent Y" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,0, 0,1,2, 0},
            {0, 1,0, 1,1,2, 0},
            {0, 1,0, 2,1,2, 0},
      };
      info = "a=d\nb=c\nB=90\nD+E=360\n(A+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .7;
      double h = w;
      double dx = paramValues[0]/100.;
      double dy = paramValues[1]/100.;

      double xp = w*(dx+dy);
      double yp = h*(dy-dx);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w, -h);
      baseTile.setPoint(2,w+w,  0);
      baseTile.setPoint(3,w+w-xp,-yp);
      baseTile.setPoint(4, xp, yp);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[1].getX(0);
      offsets[1] = tiles[0].getY(0)-tiles[1].getY(0);
      offsets[2] = tiles[0].getX(0)-tiles[2].getX(0);
      offsets[3] = tiles[0].getY(0)-tiles[2].getY(0);
   }
}
