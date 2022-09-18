package tilingTypes.NC5.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_54
   extends TilingType
{
   public TilingTypeNC5_54(){
      super( "NC5-54", 6, SymmetryType.pg );

      paramMin = new int[]{   0,  0,  0};
      paramMax = new int[]{ 100,100,100};
      paramDef = new int[]{  40, 50, 50};
      paramName = new String[]{ "Aspect", "Relative Length", "Indentation" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 5,4, 0,0,5, 1},
      };
      labels = new int[]{0,1,2,3,-1,4};
      info = "b=d\ne=a+c\nB+D=360\n(A+C+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double height = 2. * paramValues[0]/100;
      double width = 2 - height;
      double leftwidth = width * paramValues[1]/100;
      double rightwidth = width - leftwidth;
      
      double anCXA = Math.atan2(rightwidth, height/2) / DEG2RAD;
      double anEXA = Math.atan2(leftwidth, height/2) / DEG2RAD;
      double anACE = 90-anCXA;
      double anCED = 90-anEXA;
      double anCXD = 180 - anCXA - anEXA;
      double anACB = anCXD;
      double anECB = anACB - anACE;
      double maxindent = width / Math.sin((180-anCED-anECB)*DEG2RAD) * Math.sin(anCED*DEG2RAD);

      double minindent = 0;
      if( leftwidth<rightwidth ){
         double dx = width/2 - leftwidth;
         double dy = height/2 * (width/2/leftwidth - 1);
         minindent = Math.sqrt(dx*dx+dy*dy);
      }
      double lnCB = minindent + (maxindent-minindent) * paramValues[2]/100;

      double xE = -leftwidth;
      double yE = height/2;
      double xC = rightwidth;
      double yC = height/2;
      double xD =          lnCB * Math.cos(anCED * DEG2RAD);
      double yD = height + lnCB * Math.sin(anCED * DEG2RAD);
      double xB = xC + lnCB * Math.cos( (180-anECB) * DEG2RAD);
      double yB = yC + lnCB * Math.sin( (180-anECB) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, xB, yB);
      baseTile.setPoint(2, xC, yC);
      baseTile.setPoint(3, xD, yD);
      baseTile.setPoint(4,  0, height);
      baseTile.setPoint(5, xE, yE);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(1)-tiles[1].getX(3);
      offsets[3] = tiles[0].getY(1)-tiles[1].getY(3);
   }
}
