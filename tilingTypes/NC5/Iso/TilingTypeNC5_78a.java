package tilingTypes.NC5.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_78a
   extends TilingType
{
   public TilingTypeNC5_78a(){
      super( "NC5-78a: Split rectangle", 5, SymmetryType.cmm );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 60, 30, 70};
      paramName = new String[]{ "Aspect", "Indent X", "Indent Y" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,1,2, 1},
            {0, 0,1, 1,0,1, 0},
            {0, 1,2, 2,1,2, 1},
      };
      info = "a=d\nB=90\nD+E=360\n(A+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 2 * paramValues[0]/100.;
      double h = 2 - w;

      double xp = w * paramValues[1]/100.;
      double yp = h * paramValues[2]/100.;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  w,  h);
      baseTile.setPoint(3,w-xp,h-yp);
      baseTile.setPoint(4, xp, yp);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(2)-tiles[1].getX(0);
      offsets[3] = tiles[1].getY(2)-tiles[1].getY(0);
   }
}
