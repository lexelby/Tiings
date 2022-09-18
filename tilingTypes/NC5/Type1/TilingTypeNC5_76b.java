package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_76b
   extends TilingType
{
   public TilingTypeNC5_76b(){
      super( "NC5-76b: Split square", 5, SymmetryType.p4g );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 61, 18};
      paramName = new String[]{ "Indent X", "Indent Y" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 1,0, 0,1,2, 0},
            {1, 1,0, 1,1,2, 0},
            {1, 1,0, 2,1,2, 0},

            {0, 0,2, 0,2,0, 0},
            {0, 0,2, 1,2,0, 0},
            {0, 0,2, 2,2,0, 0},
            {0, 0,2, 3,2,0, 0},

            {0, 0,1, 4,0,1, 1},

            {1, 0,2, 8,2,0, 1},
            {1, 1,0, 9,1,2, 1},
            {1, 1,0,10,1,2, 1},
            {1, 1,0,11,1,2, 1},

            {0, 0,2,10,2,0, 1},
            {0, 0,2,11,2,0, 1},
            {0, 0,2,12,2,0, 1},
            
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
      offsets[0] = tiles[4].getX(1)-tiles[6].getX(1);
      offsets[1] = tiles[4].getY(1)-tiles[6].getY(1);
      offsets[2] = tiles[5].getX(1)-tiles[7].getX(1);
      offsets[3] = tiles[5].getY(1)-tiles[7].getY(1);
   }
}
