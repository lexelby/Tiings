package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bd
   extends TilingType
{
   public TilingTypeN5_01bd(){
      super( "N5-1bd", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 30};
      paramName = new String[]{ "Angle", "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,1,2, 1},
            {1, 2,1, 1,1,2, 1},
            {0, 1,2, 2,2,3, 0},
      };
      info = "c=d\nA=90\nC+D=180\n2B+C=360\n(A+B+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double a = paramValues[0]/2.;
      double h = Math.sin(a * DEG2RAD);
      double w = Math.sqrt(1-h*h);
      
      double f = paramValues[1]/100.;
      double bs = 2*w*f;
      double h2 = 2*h*(1-f);
      
      // scale
      f = 2.0 / (bs + w + 2*h);
      bs *= f;
      w *= f;
      h *= f;
      h2 *= f;

      baseTile.setPoint(0,    0,   0);
      baseTile.setPoint(1,   bs,   0);
      baseTile.setPoint(2, bs+w,   h);
      baseTile.setPoint(3,   bs, h+h);
      baseTile.setPoint(4,    0,  h2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[3].getX(3);
      offsets[1] = tiles[0].getY(4)-tiles[3].getY(3);
      offsets[2] = tiles[2].getX(4)-tiles[0].getX(3);
      offsets[3] = tiles[2].getY(4)-tiles[0].getY(3);
   }
}
