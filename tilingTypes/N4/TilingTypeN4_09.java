package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_09
   extends TilingType
{
   public TilingTypeN4_09(){
      super( "N4-9", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{ 90};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,2,3, 1},
            {0, 1,2, 0,2,1, 0},
            {1, 2,3, 2,2,3, 1},
            
            {1, 0,3, 2,0,1, 0},
            {0, 2,3, 4,2,3, 1},
            {0, 1,2, 5,2,1, 1},
            {1, 2,3, 6,2,3, 0},
      };
      info = "a+c=b\nA=90\nB+2C=360\n(B+2D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double a = getParam( paramValues,0);
      double c = 90-a/2;
      double ln3 = Math.sin((c-45)*DEG2RAD) /Math.cos(c*DEG2RAD) / Math.sqrt(2);
      double ln4 = 1+ln3;
      double ln1 = 1;
      // scale
      double f = ln4/1.5;
      ln1 /= f;
      ln3 /= f;
      ln4 /= f;
      
      double x2 = ln4 - ln3 * Math.cos( a * DEG2RAD);
      double y2 = ln3 * Math.sin( a * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln4,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3,  0,ln1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(1)-tiles[0].getX(3);
      offsets[1] = tiles[4].getY(1)-tiles[0].getY(3);
      offsets[2] = tiles[5].getX(0)-tiles[3].getX(0);
      offsets[3] = tiles[5].getY(0)-tiles[3].getY(0);
   }
}
