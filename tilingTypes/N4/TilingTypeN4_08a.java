package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_08a
   extends TilingType
{
   public TilingTypeN4_08a(){
      super( "N4-8a", 4, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 60, 10};
      paramName = new String[]{ "Relative length", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,1,2, 0},
            {0, 3,2, 1,3,0, 0},
            {1, 1,0, 2,1,2, 0},
            };
      info = "b=c\nB=90\nD=90\n(A+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double f = getParam( paramValues,0)/100.;
      double g = 1-(f*f)/((1-f)*(1-f)+f*f);
      double a = Math.sqrt(2*g);
      double b = a*f/(1-f);
      double an = 45 + Math.atan(a/b)/DEG2RAD;
      
      double x3 = b * Math.cos( an * DEG2RAD);
      double y3 = b * Math.sin( an * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  1,  0);
      baseTile.setPoint(2,  1,  1);
      baseTile.setPoint(3, x3, y3);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = paramValues[1]/100.;
      offsets[0] = tiles[1].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(0)*os+tiles[3].getX(2)*(1-os)-tiles[0].getX(0);
      offsets[3] = tiles[2].getY(0)*os+tiles[3].getY(2)*(1-os)-tiles[0].getY(0);
   }
}
